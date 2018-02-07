/**
 * Created by shixi09 on 2018/2/7.
 */
// 处理时间字符串
function getMyDate(str) {
    var oDate = new Date(str), oYear = oDate.getFullYear(), oMonth = oDate
            .getMonth() + 1, oDay = oDate.getDate(), oHour = oDate.getHours(), oMin = oDate
        .getMinutes(), oSen = oDate.getSeconds(), oTime = oYear + '-'
        + getzf(oMonth) + '-' + getzf(oDay);// 最后拼接时间
    return oTime;
}
// 补0操作
function getzf(num) {
    if (parseInt(num) < 10) {
        num = '0' + num;
    }
    return num;
}