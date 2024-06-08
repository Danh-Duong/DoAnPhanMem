<!DOCTYPE html>
<html>
<head>
    <title>Danh sách t?m v?ng</title>
</head>
<body>
    <h1>Danh sách t?m v?ng</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Mã t?m v?ng</th>
                <th>Ngày ??ng ký</th>
                <th>??a ch? ??n</th>
                <th>Lý do</th>
                <th>ID nhân kh?u</th>
                <th>Ngày b?t ??u</th>
                <th>Ngày k?t thúc</th>
                <th>Tr?ng thái duy?t</th>
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
