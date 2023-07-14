-- Tạo bảng Người dùng (User)
CREATE TABLE Users (
    UserID INT PRIMARY KEY,
    Username VARCHAR(255),
    Email VARCHAR(255),
    Password VARCHAR(255),
    PhoneNumber VARCHAR(20)
);

-- Tạo bảng Sản phẩm (Product)
CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(255),
    ProductDescription TEXT,
    Price DECIMAL(10, 2),
    Quantity INT
);

-- Tạo bảng Đơn hàng (Order)
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    UserID INT,
    OrderDate DATE,
    OrderStatus VARCHAR(50),
    DeliveryStaffID INT,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (DeliveryStaffID) REFERENCES DeliveryStaff(StaffID)
);

-- Tạo bảng Chi tiết đơn hàng (OrderDetail)
CREATE TABLE OrderDetails (
    OrderDetailID INT PRIMARY KEY,
    OrderID INT,
    ProductID INT,
    Quantity INT,
    Price DECIMAL(10, 2),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

-- Tạo bảng Nhân viên giao hàng (DeliveryStaff)
CREATE TABLE DeliveryStaff (
    StaffID INT PRIMARY KEY,
    StaffName VARCHAR(255),
    Email VARCHAR(255),
    PhoneNumber VARCHAR(20)
);
