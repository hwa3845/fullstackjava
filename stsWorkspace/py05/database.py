import os
from dotenv import load_dotenv
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
import contextlib

load_dotenv()
user = os.getenv("DB_USER")     # "scott"
passwd = os.getenv("DB_PASSWD") # "tiger"
host = os.getenv("DB_HOST")     # "mysql8"
port = os.getenv("DB_PORT")     # "3306"
db = os.getenv("DB_NAME")       # "mydb"

#python에 내장돼 있는 DB
# SQLALCHEMY_DATABASE_URL = "sqlite:///./myapi.db"
SQLALCHEMY_DATABASE_URL = f'mysql+pymysql://{user}:{passwd}@{host}:{port}/{db}?charset=utf8'

engine = create_engine(
    SQLALCHEMY_DATABASE_URL, connect_args={"check_same_thread": False}
)
#커넥션 풀과 비슷
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

Base = declarative_base()

@contextlib.contextmanager
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()