from datetime import datetime
from typing import Optional

import jwt
from starlette.responses import HTMLResponse,JSONResponse
from fastapi import Cookie, FastAPI, HTTPException, Header, Request
# from starlette.requests import Request

import models
from database import engine
from models import Question
from database import SessionLocal
from domain.question import question_router

models.Base.metadata.create_all(bind=engine)

app = FastAPI()
db = SessionLocal()

@app.get("/hello")
def hello(sub:str,content:str):
    # print(req.body())
    q = Question(subject=sub, content=content, create_date=datetime.now())
    db.add(q)
    db.commit()
    db.close()
    return 'test'

app.include_router(question_router.router)

@app.get("/items/", response_class=HTMLResponse)
async def read_items():
    return """
    <html>
        <head>
            <title>Some HTML in here</title>
        </head>
        <body>
            <h1>Look ma! HTML!</h1>
        </body>
    </html>
    """

@app.post('/ex01')
def ex01():
    # print(req.headers())
    # print(req.cookies())
    # print(req.get('msg'))
    # print(req.body())
    return HTMLResponse('<h1>ex01 page</h1>')

@app.get("/ex02")
def ex02():
    return JSONResponse(['item1','item2','item3'])


@app.get("/ex03")
def ex03(response_class=JSONResponse):
    return ['item1','item2','item3','item4']

@app.get("/ex04")
def ex04(cmsg: Optional[str]=Cookie(None),Authorization: Optional[str] = Header(None)):
    print(cmsg,Authorization)
    return []

@app.get('/create')
def jwtCreate():
    encoded = jwt.encode({"some": "payload"}, "secret", algorithm="HS256")
    return HTMLResponse(encoded)

@app.get('/info')
def jwtInfo(Authorization: Optional[str] = Header(None)):
    token=Authorization
    try:
        if token != None:
            if token.startswith('Bearer '):    
                token=token[7:]   
                info=jwt.decode(token, "secret", algorithms=["HS256"])
                return (info['some'])
    # error 400
        raise HTTPException(status_code=400, detail="item not found")
    except:
        raise HTTPException(status_code=403, detail="item not found")