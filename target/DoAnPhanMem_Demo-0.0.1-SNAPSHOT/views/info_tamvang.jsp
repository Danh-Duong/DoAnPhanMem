<!DOCTYPE html>
<html>
<head>
    <title>Danh s�ch t?m v?ng</title>
</head>
<body>
    <h1>Danh s�ch t?m v?ng</h1>
    <table border="1">
        <thead>
            <tr>
                <th>M� t?m v?ng</th>
                <th>Ng�y ??ng k�</th>
                <th>??a ch? ??n</th>
                <th>L� do</th>
                <th>ID nh�n kh?u</th>
                <th>Ng�y b?t ??u</th>
                <th>Ng�y k?t th�c</th>
                <th>Tr?ng th�i duy?t</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="tamVang" items="${listTamVang}">
                <tr>
                    <td>${tamVang.maTamVang}</td>
                    <td>${tamVang.ngayDangKi}</td>
                    <td>${tamVang.diaChiDen}</td>
                    <td>${tamVang.lyDo}</td>
                    <td>${tamVang.idNhanKhau}</td>
                    <td>${tamVang.ngayBatDau}</td>
                    <td>${tamVang.ngayKetThuc}</td>
                    <td>${tamVang.trangThaiDuyet}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
