import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { TremaSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [TremaSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [TremaSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TremaSharedModule {
  static forRoot() {
    return {
      ngModule: TremaSharedModule
    };
  }
}
