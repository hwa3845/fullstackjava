from sqlalchemy import INT, TEXT, TIMESTAMP, VARCHAR, Column, Integer, String, Text, DateTime, ForeignKey
from sqlalchemy.orm import relationship
from database import Base


class Question(Base):
    __tablename__ = "question"

    id = Column(INT, primary_key=True)
    subject = Column(TEXT, nullable=False)
    content = Column(TEXT, nullable=False)
    create_date = Column(TIMESTAMP, nullable=False)

# class Answer(Base):
#     __tablename__ = "answer"

#     id = Column(Integer, primary_key=True)
#     content = Column(Text, nullable=False)
#     create_date = Column(DateTime, nullable=False)
#     question_id = Column(Integer, ForeignKey("question.id"))
#     question = relationship("Question", backref="answers")