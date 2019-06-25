import { NgModule } from '@angular/core';

import { TremaSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
  imports: [TremaSharedLibsModule],
  declarations: [JhiAlertComponent, JhiAlertErrorComponent],
  exports: [TremaSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class TremaSharedCommonModule {}
