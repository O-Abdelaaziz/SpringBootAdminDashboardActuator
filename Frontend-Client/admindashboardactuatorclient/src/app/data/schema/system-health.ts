export class SystemHealth {
  status: string;
  components: {
    db: {
      status: string;
      details: {
        database: string;
        hello: number;
        validationQuery:string;
      };
    };
    diskSpace: {
      status: string;
      details: {
        total: number;
        free: number | string;
        threshold: number;
      };
    };
    ping:{
      status:string;
    }
  };
}
