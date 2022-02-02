
export class Coupon {

    couponName!:string;
    dateCoupon!:Date;
    custId!:number;
    venId!:number;

    constructor (couponName:string, dateCoupon:Date, custId:number, venId:number)
        {
            this.couponName=couponName;
            this.dateCoupon=dateCoupon;
            this.custId=custId;
            this.venId=venId;
        }

}


