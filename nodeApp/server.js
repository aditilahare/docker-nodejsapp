const express = require("express");
const port = 3000;
const app = express();
const request = require('request');
const bodyParser = require('body-parser');


app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json());

app.get("/", (req, res) => {
    res.send("Hello World!");
});

app.get("/todos", (req, res) => {
    let form = "<form action='/todos' method='POST'>" + "Title: <input name=title type='text'> " + "Description: <input name=description type='text'> " +
        "<button> Add </button></form>" + "\n" + "<b>Your Todos:</b>";

    request.get('http://todoapp:8080/todos', (error, response, body) => {
        if (error) return console.log(error);
        const content = `${form}<br/><br/>${body}`;
        res.send(content);
    });
});


app.post('/todos', (req, res) => {
    request.post('http://todoapp:8080/todos', {json: {Title: req.body.title, Description: req.body.description}},
        (error, response, body) => {
            if (error) console.log(error);
            res.redirect('/todos');
        });
});

app.listen(port, () => {
    console.log(`App listening on ${port}`);
});
