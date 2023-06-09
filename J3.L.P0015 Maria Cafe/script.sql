USE [master]
GO
/****** Object:  Database [MariaCafe]    Script Date: 11/09/2018 12:06:14 ******/
CREATE DATABASE [MariaCafe] ON  PRIMARY 
( NAME = N'MariaCafe', FILENAME = N'c:\Program Files (x86)\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\MariaCafe.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MariaCafe_log', FILENAME = N'c:\Program Files (x86)\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\MariaCafe_log.LDF' , SIZE = 512KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MariaCafe] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MariaCafe].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MariaCafe] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [MariaCafe] SET ANSI_NULLS OFF
GO
ALTER DATABASE [MariaCafe] SET ANSI_PADDING OFF
GO
ALTER DATABASE [MariaCafe] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [MariaCafe] SET ARITHABORT OFF
GO
ALTER DATABASE [MariaCafe] SET AUTO_CLOSE ON
GO
ALTER DATABASE [MariaCafe] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [MariaCafe] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [MariaCafe] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [MariaCafe] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [MariaCafe] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [MariaCafe] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [MariaCafe] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [MariaCafe] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [MariaCafe] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [MariaCafe] SET  ENABLE_BROKER
GO
ALTER DATABASE [MariaCafe] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [MariaCafe] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [MariaCafe] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [MariaCafe] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [MariaCafe] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [MariaCafe] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [MariaCafe] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [MariaCafe] SET  READ_WRITE
GO
ALTER DATABASE [MariaCafe] SET RECOVERY SIMPLE
GO
ALTER DATABASE [MariaCafe] SET  MULTI_USER
GO
ALTER DATABASE [MariaCafe] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [MariaCafe] SET DB_CHAINING OFF
GO
USE [MariaCafe]
GO
/****** Object:  Table [dbo].[OpeningHour]    Script Date: 11/09/2018 12:06:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OpeningHour](
	[Day] [varchar](max) NOT NULL,
	[OpenTime] [varchar](max) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[OpeningHour] ([Day], [OpenTime]) VALUES (N'Monday', N'Closed')
INSERT [dbo].[OpeningHour] ([Day], [OpenTime]) VALUES (N'Tuesday-Friday', N'10:00 - 20:00')
INSERT [dbo].[OpeningHour] ([Day], [OpenTime]) VALUES (N'Saturday and Sunday', N'11:00 - 21:00')
/****** Object:  Table [dbo].[Item]    Script Date: 11/09/2018 12:06:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[Item](
	[id] [int] NOT NULL,
	[name] [varchar](250) NULL,
	[imagePath] [varchar](250) NULL,
	[itemContent] [varchar](max) NULL,
	[publishedDate] [date] NULL,
	[price] [float] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
SET ANSI_PADDING ON
ALTER TABLE [dbo].[Item] ADD [Desc] [varchar](max) NULL
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Item] ([id], [name], [imagePath], [itemContent], [publishedDate], [price], [Desc]) VALUES (1, N'In the Afternoon', N'1.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.<br>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.<br>', CAST(0xE43E0B00 AS Date), 100000, N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea co...')
INSERT [dbo].[Item] ([id], [name], [imagePath], [itemContent], [publishedDate], [price], [Desc]) VALUES (2, N'Traditional Cakes', N'2.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.<br>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.<br>', CAST(0xE43E0B00 AS Date), 100000, N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea co...')
INSERT [dbo].[Item] ([id], [name], [imagePath], [itemContent], [publishedDate], [price], [Desc]) VALUES (3, N'Traditional Cakes', N'3.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.<br>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.<br>', CAST(0xE33E0B00 AS Date), 100000, N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea co...')
INSERT [dbo].[Item] ([id], [name], [imagePath], [itemContent], [publishedDate], [price], [Desc]) VALUES (4, N'Traditional Cakes', N'2.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.<br>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.<br>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.<br>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.<br>', CAST(0xE33E0B00 AS Date), 100000, N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea co...')
/****** Object:  Table [dbo].[Introduction]    Script Date: 11/09/2018 12:06:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Introduction](
	[contentup] [varchar](max) NOT NULL,
	[contentdown] [varchar](max) NOT NULL,
	[image] [varchar](max) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Introduction] ([contentup], [contentdown], [image]) VALUES (N'<h3>Maria''s Cosy Cage</h3>N''Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.<br>Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica', N'<h3>Visit my cafe</h3>N''Lorem ipsum dolor sit amet, consectetuer adipiscing elit<br>Gammel Torv, Copenhagen<br>Phone:  12 1234 1234', N'intro.jpg')
/****** Object:  Table [dbo].[Information]    Script Date: 11/09/2018 12:06:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[Information](
	[title] [varchar](150) NOT NULL,
	[contact] [varchar](max) NOT NULL,
	[openinghour] [varchar](150) NOT NULL,
	[mapimage] [varchar](150) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Information] ([title], [contact], [openinghour], [mapimage]) VALUES (N'Find Maria''s Cafe', N'<h3>Address and Contact</h3>Copenhagen, Denmark<br><br>Tel: 123456<br>Email: your-email@your-email.com', N'<h3>Opening hours:</h3>Monday:Closed<br>Tuesday-Friday:10:00 - 20:00<br>Saturday and Sunday:11:00 - 21:00', N'map.png')
/****** Object:  Table [dbo].[Contact]    Script Date: 11/09/2018 12:06:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[Address] [nvarchar](max) NOT NULL,
	[Tel] [nvarchar](max) NOT NULL,
	[Email] [nvarchar](max) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Contact] ([Address], [Tel], [Email]) VALUES (N'Copenhagen, Denmark', N'123456', N'your-email@your-email.com')
INSERT [dbo].[Contact] ([Address], [Tel], [Email]) VALUES (N'Hoa Lac, Hanoi', N'456789', N'your-email@gmail.com')
/****** Object:  Default [abc]    Script Date: 11/09/2018 12:06:16 ******/
ALTER TABLE [dbo].[Item] ADD  CONSTRAINT [abc]  DEFAULT ('Short desc') FOR [Desc]
GO
