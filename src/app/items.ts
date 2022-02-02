// import { stat } from 'fs';

export class Items {

    orderId!:number;
    foodId!:number;

    customerId!:number;
    vendorId!:number;
    noOfItems!:number;
    orderDateTime!:string;
    amountToBePaid!:number;
    tokenNumber!:number;
    status!:string;
    comment!:string;
    // foodPrice!:number;

    constructor(    orderId:number,
        foodId:number,

        customerId:number,
        vendorId:number,
        noOfItems:number,
        orderDateTime:string,
         amountToBePaid:number,
        tokenNumber:number,
        status:string,
        comment:string)
        {
            this.orderId=orderId;
            this.foodId=foodId;

            this.customerId=customerId;
            this.vendorId=vendorId;
            this.noOfItems=noOfItems;
            this.orderDateTime=orderDateTime;
            this.amountToBePaid=amountToBePaid;
            this.tokenNumber=tokenNumber;
            this.status=status;
            this.comment=comment;
        }

}


