function getRoot() {
    var curPath = window.document.location.href;
    var pathname = window.document.location.pathname;
    var pos = curPath.indexOf(pathname);
    return curPath.substring( 0, pos )+pathname.substring(0,pathname.substring(1).indexOf("/")+1);
}

window.formatDate =function (date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
}