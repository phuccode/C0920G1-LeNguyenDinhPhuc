function greeter(person: string): string {
    return "Hello, " + person;
}

// @ts-ignore
let user: string = "Jane User";

// @ts-ignore
console.log(greeter(user));
