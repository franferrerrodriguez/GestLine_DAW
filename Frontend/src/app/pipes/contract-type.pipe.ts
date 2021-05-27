import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'contractType'
})
export class ContractTypePipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return value == 'PREPAID' ? 'PREPAGO' : value == 'POSPAID' ? 'POSPAGO' : 'FIJO';
  }

}