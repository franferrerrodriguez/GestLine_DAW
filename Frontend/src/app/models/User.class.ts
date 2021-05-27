export class User {

    document: string;
    email: string;
    password: string;

    constructor(document: string, email: string, password: string) {
        this.document = document;
        this.email = email;
        this.password = password;
    }

}