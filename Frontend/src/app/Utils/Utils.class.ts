export class Utils {

   public getMonthByNumber(date:Date){
      let month = date.getMonth() + 1;
      switch(month) { 
         case 1:
            return "Enero";
         case 2:
            return "Febrero";
         case 3:
            return "Marzo";
         case 4:
            return "Abril";
         case 5:
            return "Mayo";
         case 6:
            return "Junio";
         case 7:
            return "Julio";
         case 8:
            return "Agosto";
         case 9:
            return "Septiembre";
         case 10:
            return "Octubre";
         case 11:
            return "Noviembre";
         case 12:
            return "Diciembre";
        }
    }

    public byteToGb(param:number, fixed:number = 2){
      return +(param / 1024 / 1024 / 1024).toFixed(fixed);
    }

   /**
    * @number partialBytes
    * @number totalBytes
    * @boolean isByte (if is byte to gb)
    * @boolean round (for absolut round)
    * Method that calculates the percentage result partialBytes of totalBytes
    * @returns Return the percentage partialBytes of totalBytes
    */
    public getPercentage(partialBytes:number, totalBytes:number, isByte:boolean = false, round:boolean = false){
      let percentage:number = 0;
      if(partialBytes != undefined && partialBytes != null 
         && totalBytes != undefined && totalBytes != null){
            if(totalBytes > 0 && partialBytes > 0){
               if(!isByte)
                  percentage = +((partialBytes * 100) / totalBytes).toFixed(0);
               else
                  percentage = +((this.byteToGb(partialBytes) * 100) / this.byteToGb(totalBytes)).toFixed(0);
               if(round)
                  percentage = Math.round(percentage / 10) * 10;
            }else if(totalBytes == -1) {
               percentage = 100;
            }
         }
         return percentage;
    }

}