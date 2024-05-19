from flask import Flask, render_template
import redis
import os

app = Flask(__name__)

REDIS_SERVER = os.getenv('REDIS_SERVER', 'localhost')
REDIS_PORT = os.getenv('REDIS_PORT', 6379)
redis_client_instance = None

def redis_client():
    global redis_client_instance

    if not redis_client_instance:
        print(f'Connecting to Redis server at {REDIS_SERVER}:{REDIS_PORT}')
        redis_client_instance = redis.StrictRedis(host=REDIS_SERVER, port=REDIS_PORT, db=0)

    return redis_client_instance

def get_visit_count():
    count = redis_client().get('visit_count')
    if count is None:
        return 0
    return int(count)

def increment_visit_count():
    redis_client().incr('visit_count')

@app.route('/hello')
def hello():
    return 'Hello, World!'

@app.route('/')
def index():
    increment_visit_count()
    visit_count = get_visit_count()
    return (render_template('index.html', visit_count=visit_count))

if __name__ == '__main__':
    app.run(host='0.0.0.0')
