export class Client {
    document: string;
    documentType: string;
    clientType: string;
    name: string;
    firstSurname: string;
    secondSurname: string;
    birthDate: string;
    email: string;
    onlineInvoice: boolean;
    address: Address;
    billing: Billing;
    password:string;
    repeatPassword:string;
}

class Address {
    type: string;
    direction: string;
    number: string;
    stairs: string;
    floor: string;
    door: string;
    location: string;
    province: string;
    postalCode: string;
    country: string;
}

class Billing {
    entity: string;
    office: string;
    dc: string;
    account: string;
    address: Address;
}