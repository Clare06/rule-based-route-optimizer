export interface RgoodResponse {
    product: {
      pid: number;
      productName: string;
      weightPerUnit: number;
      volumePerUnit: number;
      availableQuantity: number;
    };
    year: number;
    month: number;
    totalQuantity: number;
  }