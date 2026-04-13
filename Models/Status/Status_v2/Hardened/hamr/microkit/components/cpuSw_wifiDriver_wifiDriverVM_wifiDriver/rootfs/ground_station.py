from flask import Flask

# Create the application instance
app = Flask(__name__)

# Define a route for the homepage
@app.route("/")
def hello_world():
    return "<h1 style='color:blue'>Hello There!</h1>"

if __name__ == '__main__':
     app.run()