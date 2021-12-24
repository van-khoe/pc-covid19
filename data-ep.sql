-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: medican
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `idblog` int NOT NULL AUTO_INCREMENT,
  `tieude` varchar(1000) NOT NULL,
  `noidung` varchar(1500) NOT NULL,
  `hinhanh` varchar(500) NOT NULL,
  `ngaytao` date NOT NULL,
  `nguoitao` varchar(45) NOT NULL,
  PRIMARY KEY (`idblog`,`nguoitao`),
  KEY `nguoitao_idx` (`nguoitao`),
  CONSTRAINT `nguoitao` FOREIGN KEY (`nguoitao`) REFERENCES `taikhoan` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (1,'Ngày 29/11: Có 13.770 ca COVID-19, riêng Hà Nội có số mắc cao nhất tính đến nay với 429 ca','Tính từ 16h ngày 28/11 đến 16h ngày 29/11, trên Hệ thống Quốc gia quản lý ca bệnh COVID-19 ghi nhận 13.770 ca nhiễm mới, trong đó 12 ca nhập cảnh và 13.758 ca ghi nhận trong nước (tăng 830 ca so với ngày trước đó) tại 59 tỉnh, thành phố (có 7.601 ca trong cộng đồng).','person_7.jpg','2021-12-01','khoe'),(2,'Hà Nội sẽ thí điểm điều trị F0 thể nhẹ và không triệu chứng tại nhà','Chiều 29/11, Thường trực Thành ủy Hà Nội đã họp về công tác phòng, chống dịch COVID-19 trên địa bàn Thành phố.Về tình hình ca mắc COVID-19, giai đoạn từ ngày 21/11 - 29/11, trên địa bàn ghi nhận 2.267 bệnh nhân, trong đó, đã tiêm 2 mũi 1.402 trường hợp (61,8%), 213 trường hợp đã tiêm 1 mũi (9,4%). Trung bình mỗi ngày ghi nhận 284 ca/ngày, tăng so với tuần từ ngày 14/11 - 20/11 ghi nhận trung bình 226 ca/ngày. Tỷ lệ F1 chuyển thành F0 có xu hướng gia tăng nhanh.','blog2.jpg','2021-12-01','khoe'),(3,'Người Hà Nội tới các địa điểm sau cần liên hệ y tế ngay','Nhà hàng Doncook tại số 130 phố Trung Hoà, phường Yên Hoà, quận Cầu Giấy,Trung tâm Kiểm soát bệnh tật thành phố Hà Nội thông báo tìm người đã đến Nhà hàng Doncook tại số 130 phố Trung Hoà, phường Yên Hoà, quận Cầu Giấy,Trụ sở Công ty IFC tại số 9 Lô 1G - Khu đô thị Trung Yên, phường Trung Hoà, quận Cầu Giấy, trong thời gian từ ngày 13 đến ngày 27/11.Thông báo được phát đi sau khi tại các địa điểm này ghi nhận 4 nhân viên mắc COVID-19. Những người đã đến các địa điểm trên, trong thời gian như thông báo chủ động tự cách ly tại nhà và liên hệ ngay với Trạm Y tế/Trung tâm Y tế nơi cư trú, để được hỗ trợ hoặc gọi đến các số điện thoại: 0243.833.2846 (Trạm y tế phường Yên Hoà, Cầu Giấy), 0243.5566.535 (Trạm y tế phường Trung Hoà, Cầu Giấy), 0243.993.6118 (Trung tâm y tế quận Cầu Giấy), hoặc CDC Hà Nội: 0241022 (nhánh 2)/ 0969.082.115/0949.396.115, để được tư vấn và hướng dẫn. Tất cả người dân trên địa bàn Hà Nội, khi có một trong các biểu hiện như: sốt, ho, đau họng, khó thở, đau người, mệt mỏi, ớn lạnh, giảm hoặc mất vị giác hoặc khứu giác, cần liên hệ ngay với trạm y tế phường, xã nơi lưu trú để được hướng dẫn và làm xét nghiệm SARS-CoV-2 miễn phí, nhằm phát hiện sớm nguy cơ mắc bệnh COVID-19.','blog3.jpeg','2021-12-01','khoe'),(4,'Nhiều tỉnh thành cho học sinh đi học trở lại từ tuần này','Đà Nẵng: Ngày 29/11, học sinh lớp 10 và 11 TP. Đà Nẵng trở lại trường. Trước đó, từ 13h30 ngày 28/11, phường Nại Hiên Đông chuyển cấp độ dịch từ cấp độ 3 xuống cấp độ 2 nên 100% học sinh sẽ đến trường học trực tiếp.Quảng Nam: Chiều 28/11, UBND TP. Tam Kỳ có Công văn về việc cho phép học sinh trên địa bàn thành phố đi học trở lại từ 29/11. Theo đó, học sinh tiểu học, THCS trên địa bàn TP. Tam Kỳ sẽ đến trường đi học trực tiếp trở lại từ hôm nay; trong đó cấp tiểu học chỉ học 1 buổi và không tổ chức bán trú, THCS học trực tiếp, không tổ chức các hoạt động ngoại khóa, ngoài giờ lên lớp. Riêng Trường THCS Lý Thường Kiệt triển khai dạy học trực tuyến 1 tuần, từ 29/11-4/12. Bậc học mầm non tiếp tục được nghỉ học thêm 1 tuần, từ 29/11-4/12.Quảng Bình: Từ hôm nay, các cơ sở giáo dục trên địa bàn TP Đồng Hới (trừ địa bàn xã Bảo Ninh) tổ chức dạy học trực tiếp cho tất cả học sinh các bậc học đảm bảo \\\"thích ứng an toàn, linh hoạt, kiểm soát hiệu quả dịch COVID-19\\','blog4.jpg','2021-12-01','khoe'),(5,'Hà Nội: Kỷ lục 301 ca COVID-19, thêm ổ dịch mới, khẩn tìm đến ngân hàng có người dương tính','Sở Y tế Hà Nội tối 28/11 thông báo trong 24 giờ qua ghi nhận 301 ca COVID-19 mới, trong đó có 141 ca cộng đồng, 133 ca trong khu cách ly và 27 ca khu phong tỏa. Đây là ngày ghi nhận kỷ lục số ca mắc trong 24 giờ cao nhất từ trước tới nay.','blog5.jpg','2021-12-01','khoe'),(6,'Hà Nội lập kỷ lục \\\'kép\\\': 390 ca nhiễm mới, 220 ca cộng đồng','Sở Y tế Hà Nội tối 29/11 cho biết trên địa bàn thành phố ghi nhận 390 ca dương tính, trong đó có 220 ca cộng đồng, 109 ca tại khu cách ly và 61 ca tại khu phong toả. Đây là ngày ghi nhận số ca mắc trong 24 giờ và ca cộng đồng cao nhất từ trước tới nay.Phân bố 390 ca dương tính tại 139 xã/phường/thị trấn thuộc 29/30 quận, huyện: Đống Đa (177), Đông Anh (23), Đan Phượng (23), Gia Lâm (23), Quốc Oai (16), Hoài Đức (15), Hai Bà Trưng (11), mê Linh (11), Ba Đình (10), Hà Đông (10), Bắc Từ Liêm (8), Thanh Oai (8), Thường Tín (7), Hoàn Kiếm (6), Tây Hồ (6), Chương Mỹ (5), Sơn Tây (5), Mỹ Đức (4), Thanh Xuân (4), Phú Xuyên (3), Ba Vì (3), Sóc Sơn (2), Ứng Hòa (2), Cầu Giấy (1), Long Biên (1), Nam Từ Liêm (1), Thạch Thất (1), Thanh Trì (1)','blog6.jpg','2021-11-01','khoe'),(7,'Hà Nội tiêm vaccine COVID-19 cho học sinh lớp 7, 8','Tại điểm trường THCS Lê Ngọc Hân - quận Hai Bà Trưng sáng nay, nhà trường tổ chức phân lịch tiêm cụ thể đối với học sinh từng khối để tránh tập trung đông người. Để thực hiện khai báo tiêm chủng, nhà trường yêu cầu phụ huynh chuẩn bị mã số định danh của học sinh từ trước.Trước đó, từ ngày 23/11, Hà Nội chính thức triển khai tiêm vaccine COVID-19 của Pfizer cho học sinh từ lớp 10, 11 và 12. Đến ngày 27/11, Hà Nội bắt đầu tiêm cho học sinh lớp 9.','blog7.jpeg','2021-12-03','khoe');
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `capquyen`
--

DROP TABLE IF EXISTS `capquyen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `capquyen` (
  `idcapquyen` int NOT NULL AUTO_INCREMENT,
  `taikhoan_username` varchar(45) NOT NULL,
  `vaitro_idvaitro` varchar(10) NOT NULL,
  PRIMARY KEY (`idcapquyen`,`taikhoan_username`,`vaitro_idvaitro`),
  KEY `fk_capquyen_taikhoan_idx` (`taikhoan_username`),
  KEY `fk_capquyen_vaitro1_idx` (`vaitro_idvaitro`),
  CONSTRAINT `fk_capquyen_taikhoan` FOREIGN KEY (`taikhoan_username`) REFERENCES `taikhoan` (`username`),
  CONSTRAINT `fk_capquyen_vaitro1` FOREIGN KEY (`vaitro_idvaitro`) REFERENCES `vaitro` (`idvaitro`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capquyen`
--

LOCK TABLES `capquyen` WRITE;
/*!40000 ALTER TABLE `capquyen` DISABLE KEYS */;
INSERT INTO `capquyen` VALUES (5,'khoe','ADMIN'),(6,'tai','ADMIN'),(7,'Monkey','USER'),(8,'DIRE','USER'),(9,'hichaocau','USER');
/*!40000 ALTER TABLE `capquyen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dottiem`
--

DROP TABLE IF EXISTS `dottiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dottiem` (
  `iddottiem` varchar(50) NOT NULL,
  `ngaytiem` date NOT NULL,
  `diadiemtiem` varchar(100) NOT NULL,
  `vacxin_idvacxin` varchar(45) NOT NULL,
  PRIMARY KEY (`iddottiem`,`vacxin_idvacxin`),
  KEY `fk_dottiem_vacxin1_idx` (`vacxin_idvacxin`),
  CONSTRAINT `fk_dottiem_vacxin1` FOREIGN KEY (`vacxin_idvacxin`) REFERENCES `vacxin` (`idvacxin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dottiem`
--

LOCK TABLES `dottiem` WRITE;
/*!40000 ALTER TABLE `dottiem` DISABLE KEYS */;
INSERT INTO `dottiem` VALUES ('D1','2020-10-20','Cần Thơ','Astra'),('D2','2020-10-10','Tiền Giang','Comirnaty'),('D4','2021-12-17','Hậu Giang','Vero'),('D6','2021-10-14','Hậu Giang','Vero'),('D7','2021-02-02','Cần Thơ','Astra'),('D8','2021-02-02','Tiền Giang','Comirnaty');
/*!40000 ALTER TABLE `dottiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khaibaoyte`
--

DROP TABLE IF EXISTS `khaibaoyte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khaibaoyte` (
  `idkhaibaoyte` bigint NOT NULL AUTO_INCREMENT,
  `hoten` varchar(50) NOT NULL,
  `cmnd` varchar(50) NOT NULL,
  `ngaysinh` date NOT NULL,
  `gioitinh` tinyint NOT NULL,
  `diachi` varchar(100) NOT NULL,
  `bieuhien` varchar(100) NOT NULL,
  `tiepxuc` varchar(100) NOT NULL,
  `ngaykhaibao` date NOT NULL,
  `taikhoan_username` varchar(45) NOT NULL,
  PRIMARY KEY (`idkhaibaoyte`,`taikhoan_username`),
  KEY `fk_khaibaoyte_taikhoan1_idx` (`taikhoan_username`),
  CONSTRAINT `fk_khaibaoyte_taikhoan1` FOREIGN KEY (`taikhoan_username`) REFERENCES `taikhoan` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khaibaoyte`
--

LOCK TABLES `khaibaoyte` WRITE;
/*!40000 ALTER TABLE `khaibaoyte` DISABLE KEYS */;
INSERT INTO `khaibaoyte` VALUES (1,'Phan Văn Khỏe','330001323','2021-12-05',1,'Cần Thơ','1','1','2021-12-05','khoe'),(2,'Đỗ Tấn Tài','03158654897','2001-04-30',1,'Cần Thơ','0','0','2021-12-05','tai');
/*!40000 ALTER TABLE `khaibaoyte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lichtestcd`
--

DROP TABLE IF EXISTS `lichtestcd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lichtestcd` (
  `idlichtestcd` int NOT NULL AUTO_INCREMENT,
  `ngaytest` date NOT NULL,
  `soluongnguoitest` int NOT NULL,
  `mauamtinh` int NOT NULL,
  `mauduongtinh` int unsigned NOT NULL,
  `tinhthanh` varchar(50) NOT NULL,
  PRIMARY KEY (`idlichtestcd`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lichtestcd`
--

LOCK TABLES `lichtestcd` WRITE;
/*!40000 ALTER TABLE `lichtestcd` DISABLE KEYS */;
INSERT INTO `lichtestcd` VALUES (1,'2020-10-10',1000,990,10,'Tỉnh Hoà Bình'),(2,'2020-10-11',900,800,100,'Tỉnh Cao Bằng'),(3,'2021-11-30',90,80,10,'Tỉnh Phú Thọ'),(4,'2021-11-25',920,910,10,'Thành phố Hải Phòng'),(6,'2021-11-07',788,787,1,'Tỉnh Ninh Thuận'),(7,'2021-11-30',233,230,3,'Tỉnh Bắc Ninh'),(8,'2021-11-28',1000,1000,0,'Tỉnh Điện Biên'),(9,'2021-11-30',2000,0,2000,'Tỉnh Lai Châu'),(10,'2021-12-01',3000,3000,0,'Tỉnh Hậu Giang'),(11,'2021-11-07',810,799,11,'Tỉnh Vĩnh Long'),(15,'2021-12-17',6000,5988,12,'Thành phố Hà Nội'),(16,'2021-12-11',500000,490000,10000,'Tỉnh Lào Cai');
/*!40000 ALTER TABLE `lichtestcd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoitiem`
--

DROP TABLE IF EXISTS `nguoitiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoitiem` (
  `idnguoitiem` int NOT NULL AUTO_INCREMENT,
  `hoten` varchar(45) NOT NULL,
  `ngaysinh` date NOT NULL,
  `gioitinh` tinyint NOT NULL,
  `cmnd` varchar(45) NOT NULL,
  `tiensubenh` varchar(100) NOT NULL,
  `taikhoan_username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idnguoitiem`,`taikhoan_username`),
  KEY `fk_dangkytiemchung_taikhoan1_idx` (`taikhoan_username`),
  CONSTRAINT `fk_dangkytiemchung_taikhoan1` FOREIGN KEY (`taikhoan_username`) REFERENCES `taikhoan` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoitiem`
--

LOCK TABLES `nguoitiem` WRITE;
/*!40000 ALTER TABLE `nguoitiem` DISABLE KEYS */;
INSERT INTO `nguoitiem` VALUES (8,'Phan Văn Khỏe','2004-06-15',1,'0231521235','không','khoe','dotantai31@gmail.com'),(12,'Lương Trọng Nghĩa','2001-11-27',0,'6436346346','Trĩ','khoe','dotantai31@gmail.com'),(13,'Trần Thị Kim Thanh','2001-05-30',0,'3125188532','Không có','tai','taidtpc00715@fpt.edu.vn'),(14,'Đỗ Tấn Tài','2001-04-30',1,'0315865489','Không có','tai','dotantai31@gmail.com'),(15,'Huỳnh Nguyễn Phương Uyên','2001-04-03',1,'0315865456','Không có','khoe','nhokdo3004@gmail.com'),(16,'Phan Thế Nghĩa','2001-12-05',1,'0315865455','Thận','khoe','nghialtpc00727@fpt.edu.vn'),(17,'Thái Hoàng Mai Học','2001-11-20',1,'0231584364','Không có','tai','nghialtpc00727@fpt.edu.vn'),(18,'Nguyễn Hồ Huế','2001-09-15',0,'0254896487','Không có','tai','dotantai3444@gmail.com');
/*!40000 ALTER TABLE `nguoitiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieutiem`
--

DROP TABLE IF EXISTS `phieutiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieutiem` (
  `idphieutiem` bigint NOT NULL AUTO_INCREMENT,
  `cosoyte` varchar(45) NOT NULL,
  `diachi` varchar(45) NOT NULL,
  `dangkytiemchung_iddangkytiemchung` int NOT NULL,
  `dottiem_iddottiem` varchar(50) NOT NULL,
  PRIMARY KEY (`idphieutiem`,`dangkytiemchung_iddangkytiemchung`,`dottiem_iddottiem`),
  KEY `fk_phieudangkylichhen_dangkytiemchung1_idx` (`dangkytiemchung_iddangkytiemchung`),
  KEY `fk_phieutiem_dottiem1_idx` (`dottiem_iddottiem`),
  CONSTRAINT `fk_phieudangkylichhen_dangkytiemchung1` FOREIGN KEY (`dangkytiemchung_iddangkytiemchung`) REFERENCES `nguoitiem` (`idnguoitiem`),
  CONSTRAINT `fk_phieutiem_dottiem1` FOREIGN KEY (`dottiem_iddottiem`) REFERENCES `dottiem` (`iddottiem`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieutiem`
--

LOCK TABLES `phieutiem` WRITE;
/*!40000 ALTER TABLE `phieutiem` DISABLE KEYS */;
INSERT INTO `phieutiem` VALUES (10,'Thành phố Cần Thơ','288 Nguyễn Văn Linh, Ninh Kiều, Cần Thơ',8,'D1'),(11,'Thành phố Cần Thơ','288 Nguyễn Văn Linh, Ninh Kiều, Cần Thơ',8,'D7'),(12,'Tỉnh Tiền Giang','Tiền Giang',16,'D2'),(13,'Tỉnh Tiền Giang','Tiền Giang',16,'D8'),(14,'Tỉnh Hậu Giang','Hậu Giang',12,'D4'),(15,'Tỉnh Hậu Giang','Hậu Giang',15,'D4'),(16,'Tỉnh Hậu Giang','Hậu Giang',15,'D6');
/*!40000 ALTER TABLE `phieutiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `username` varchar(45) NOT NULL,
  `hoten` varchar(45) NOT NULL,
  `matkhau` varchar(45) NOT NULL,
  `diachi` varchar(45) NOT NULL,
  `gioitinh` tinyint NOT NULL,
  `sdt` varchar(45) NOT NULL,
  `ngaysinh` date NOT NULL,
  `trangthai` tinyint NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('DIRE','Đỗ Sông Đổ Biển','123','Cần Thơ',1,'0335273073','2001-04-30',1,'dotantai31@gmail.com'),('hichaocau','Đỗ Tà Ta','1234','Cần Thơ',1,'0762994647','2001-04-30',0,'dotantai31@gmail.com'),('khoe','Phan Văn Khỏe','1234','Tiền Giang, Việt Nam',1,'0382382832','2001-10-25',1,'dotantai31@gmai.com'),('Monkey','Đổ Khỉ Nghèo','123','Cần Thơ',1,'0762994647','2001-04-30',1,'dotantai31@gmai.com'),('tai','Đỗ Tấn Tài','123','Cần Thơ',1,'0335273073','2001-12-20',1,'taidtpc00715@fpt.edu.vn');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacxin`
--

DROP TABLE IF EXISTS `vacxin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacxin` (
  `idvacxin` varchar(45) NOT NULL,
  `tenvacxin` varchar(45) NOT NULL,
  `tenhang` varchar(45) NOT NULL,
  `tenquocgia` varchar(45) NOT NULL,
  `thoigianmui2` int NOT NULL,
  PRIMARY KEY (`idvacxin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacxin`
--

LOCK TABLES `vacxin` WRITE;
/*!40000 ALTER TABLE `vacxin` DISABLE KEYS */;
INSERT INTO `vacxin` VALUES ('Astra','AstraZeneca','Tập đoàn AstraZeneca','Virgin Islands, US',8),('Comirnaty','Comirnaty',' hãng Pfizer','Bỉ',3),('Janssen','Janssen','Janssen','Bỉ và Hà Lan',0),('Spikevax','Spikevax','Moderna','Mỹ',4),('SPUTNIK','SPUTNIK V','Viện Nghiên cứu Gamaleya','Nga',3),('Vero','Vero Cell','Sinopharm','Trung Quốc',4);
/*!40000 ALTER TABLE `vacxin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaitro`
--

DROP TABLE IF EXISTS `vaitro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaitro` (
  `idvaitro` varchar(10) NOT NULL,
  `ten` varchar(45) NOT NULL,
  PRIMARY KEY (`idvaitro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaitro`
--

LOCK TABLES `vaitro` WRITE;
/*!40000 ALTER TABLE `vaitro` DISABLE KEYS */;
INSERT INTO `vaitro` VALUES ('ADMIN','Quản trị'),('USER','Người dùng');
/*!40000 ALTER TABLE `vaitro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-24 14:42:34
