// import './scss/styles.scss';
console.log("it's work!");
var arrayA = [1, 2, 3];
console.log(arrayA);
var arrayB = ['a', 'b', 'c'];
console.log(arrayB);
var Phuc = /** @class */ (function () {
    function Phuc(num, str) {
        this.num = num;
        this.str = str;
    }
    Phuc.prototype.a = function () {
        var a = 1;
        return a + 1;
    };
    return Phuc;
}());
var now = new Phuc(1, '2');
console.log(now);
console.log(now.a());
