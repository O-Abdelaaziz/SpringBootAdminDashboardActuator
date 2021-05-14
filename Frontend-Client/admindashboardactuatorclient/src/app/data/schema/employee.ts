export class Employee {
    public id: number;
    public code: string;
    public idNumber: string;
    public firstName: string;
    public lastName: string;
    public birthday: string;
    public country: string;
    public address: string;
    public email: string;
    public creditCardNumber: string;
    public creditCardType: string;
    public creditCardExpiry: string;
    public promotionCode: string;
    public profession: string;
    public skills: string;
    public jobTitle: string;
    public phone: string;
    public joinDate: string;
    public imageUrl: string;
    public description: string;

  constructor(
    id: number, 
    code: string, 
    idNumber: string, 
    firstName: string, 
    lastName: string, 
    birthday: string, 
    country: string, 
    address: string, 
    email: string, 
    creditCardNumber: string, 
    creditCardType: string, 
    creditCardExpiry: string, 
    promotionCode: string, 
    profession: string, 
    skills: string, 
    jobTitle: string, 
    phone: string, 
    joinDate: string, 
    imageUrl: string, 
    description: string
) {
    this.id = id
    this.code = code
    this.idNumber = idNumber
    this.firstName = firstName
    this.lastName = lastName
    this.birthday = birthday
    this.country = country
    this.address = address
    this.email = email
    this.creditCardNumber = creditCardNumber
    this.creditCardType = creditCardType
    this.creditCardExpiry = creditCardExpiry
    this.promotionCode = promotionCode
    this.profession = profession
    this.skills = skills
    this.jobTitle = jobTitle
    this.phone = phone
    this.joinDate = joinDate
    this.imageUrl = imageUrl
    this.description = description
  }
    
}
