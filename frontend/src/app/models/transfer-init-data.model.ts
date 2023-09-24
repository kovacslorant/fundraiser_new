import {TargetOptionModel} from "./target-option.model";

export interface TransferInitDataModel {
  sourceAccountName: string;
  targetAccountOptions: TargetOptionModel[];
  balance: number;
}
