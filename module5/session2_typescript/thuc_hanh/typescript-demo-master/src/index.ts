// import './scss/styles.scss';
console.log(`it's work!`);
let arrayA: Array<number> = [1, 2, 3];
console.log(arrayA);

let arrayB: any[] = ['a', 'b', 'c'];
console.log(arrayB);

class Phuc {
    public num: number;
    private str: string;

    constructor(num: number, str: string) {
        this.num = num;
        this.str = str;
    }

    public a() {
        let a = 1;
        return a + 1;
    }
}

let now = new Phuc(1, '2');

console.log(now);
console.log(now.a());



