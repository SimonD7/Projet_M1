from fastapi import FastAPI

app = FastAPI()

file: str = 'csv/76575_000AB.csv'


@app.get("/")
async def root():
    return {file}


