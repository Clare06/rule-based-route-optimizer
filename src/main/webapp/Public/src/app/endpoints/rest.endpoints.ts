const root="http://localhost:8080";

export const ENDPOINTS = {
    LOGIN: `${root}/authenticate`,
    ORDERGET: `${root}/order`,
    ITEMGET: `${root}/item`,
    ITEMGETBYOID: `${root}/item/group-by-oid/`,
    GETRETURN:`${root}/outletbackhauling`,
    GETORDERBYID: `${root}/order/getByIds/`,
    GETRETURNBYID: `${root}/outletbackhauling/getByObId/`,
    GETVEHICLEBYID: `${root}/vehicle/bycapacity`,
    GETINVENTORY: `${root}/inventory`,
    GETPRODUCT: `${root}/product`,
    GETVEHICLE: `${root}/vehicle`,
    GETRGOOD: `${root}/rgood`,
    GETUSERBYID: `${root}/userbyid/`,
    UPDATEUSER:`${root}/users/`,
    UPDP:`${root}/profupload/`,
    LISTBYUID:`${root}/item/listbyuid/`,
    RETLISTBYUID:`${root}/backhaul/listbyuid/`,
    SENDDATAOBJ:`${root}/opt/map`,
    RESETPASS:`${root}/reset-password`,
    VERIFYOTP:`${root}/verify-otp`,
    SETNEWPASS: `${root}/new-pass`,
    CREATEUSER:`${root}/users`,
    LISTUSER:`${root}/getusers`,
    DELETEUSER:`${root}/deleteuser/`,
    DRIVERDELIVERY: `${root}/driverdeliver/`
}