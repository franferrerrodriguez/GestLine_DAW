// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

declare var CONFIG_PRE: any;

export const environment = {
  production: false,
  packagejson: require('../../package.json'),
  sessionTime: 5
};

export const environmentAPI = {
  zuul: CONFIG_PRE.gateway
};

export const API = {
  msauthenticationv1: environmentAPI.zuul + '/ms-authentication/v1/',
  msclientmanagementv1: environmentAPI.zuul + '/ms-client-management/v1/',
  mscontractv1: environmentAPI.zuul + '/ms-contract/v1/',
  msinvoicev1: environmentAPI.zuul + '/ms-invoice/v1/'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.