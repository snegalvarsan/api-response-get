from flask import Flask, request, jsonify, render_template

app = Flask(__name__)

data_store = []

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/api/hello', methods=['GET'])
def say_hello():
    name = request.args.get('name', 'World')
    return jsonify(message=f"Hello, {name}!")

@app.route('/api/data', methods=['POST'])
def add_data():
    data = request.json.get('data')
    if not data:
        return jsonify(error="Missing data"), 400
    data_store.append(data)
    print(data_store)
    return jsonify(message="Data added successfully", data=data), 201

@app.route('/api/data', methods=['DELETE'])
def delete_data():
    data = request.json.get('data')
    if data in data_store:
        data_store.remove(data)
        return jsonify(message="Data deleted successfully", data=data)
    print(data_store)
    return jsonify(error="Data not found"), 404

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8000, debug=True)