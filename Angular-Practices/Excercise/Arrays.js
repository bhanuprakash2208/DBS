var x = {
    username: "Bhanu",
    password: "sai",
    marks: [70, 80, 90],
    scores: []
};
var total = 0;
x.marks.forEach(function (Element, index) {
    total += Element;
});
x.scores = x.marks.map(function (element, index) {
    return { score: element };
});
console.log(x);
