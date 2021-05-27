export class Notification {

    public title:string;
    public message:string;
    public type:string;
    public close: boolean;

    constructor(type: Type, message: string = "", close: boolean = true) {
        this.type = type;
        this.message = message;
        this.close = close;

        switch(type) { 
            case Type.Success: { 
                this.title = "Completado";
                if(!message)
                    this.message = "La operación se ha completado con éxito.";
               break; 
            }
            case Type.Error: { 
                this.title = "Error";
                if(!message)
                    this.message = "Ha ocurrido un error. Por favor, inténtelo de nuevo más tarde.";
                break; 
            }
             case Type.Alert: { 
                this.title = "Advertencia";
                if(!message)
                this.message = "Ha ocurrido una advertencia. Por favor, revísela.";
                break; 
            }
             case Type.Default: { 
                this.title = "Mensaje";
                if(!message)
                this.message = "La operación se ha completado.";
                break; 
            }
         } 

    }

    public static Type(){
        return Type;
    }

}

enum Type {
    Success = "success",
    Error = "danger",
    Alert = "warning",
    Default = "info"
}