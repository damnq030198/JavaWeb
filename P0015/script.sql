USE [master]
GO
/****** Object:  Database [P0015]    Script Date: 7/21/2017 8:51:47 AM ******/
CREATE DATABASE [P0015]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'P0015', FILENAME = N'E:\Setup\SQLServer2016\MSSQL13.MSSQLSERVER\MSSQL\DATA\P0015.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'P0015_log', FILENAME = N'E:\Setup\SQLServer2016\MSSQL13.MSSQLSERVER\MSSQL\DATA\P0015_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [P0015] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [P0015].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [P0015] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [P0015] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [P0015] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [P0015] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [P0015] SET ARITHABORT OFF 
GO
ALTER DATABASE [P0015] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [P0015] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [P0015] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [P0015] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [P0015] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [P0015] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [P0015] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [P0015] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [P0015] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [P0015] SET  DISABLE_BROKER 
GO
ALTER DATABASE [P0015] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [P0015] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [P0015] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [P0015] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [P0015] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [P0015] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [P0015] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [P0015] SET RECOVERY FULL 
GO
ALTER DATABASE [P0015] SET  MULTI_USER 
GO
ALTER DATABASE [P0015] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [P0015] SET DB_CHAINING OFF 
GO
ALTER DATABASE [P0015] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [P0015] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [P0015] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'P0015', N'ON'
GO
ALTER DATABASE [P0015] SET QUERY_STORE = OFF
GO
USE [P0015]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [P0015]
GO
/****** Object:  Table [dbo].[CakeAbout]    Script Date: 7/21/2017 8:51:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CakeAbout](
	[Title] [varchar](150) NULL,
	[Content] [varchar](2000) NULL,
	[Image] [varchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 7/21/2017 8:51:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[EntryName] [varchar](50) NULL,
	[EntryContent] [varchar](500) NULL,
	[Image] [varchar](50) NULL,
	[Date] [date] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ShopAbout]    Script Date: 7/21/2017 8:51:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ShopAbout](
	[Address] [varchar](150) NULL,
	[Tel] [int] NULL,
	[Email] [varchar](50) NULL,
	[OpeningHours] [varchar](250) NULL,
	[Signature] [varchar](50) NULL,
	[IntroContent] [varchar](500) NULL,
	[IntroImage] [varchar](50) NULL
) ON [PRIMARY]
GO
INSERT [dbo].[CakeAbout] ([Title], [Content], [Image]) VALUES (N'About my Cakes', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.

Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica', N'i282319414620354444._szw480h1280_.jpg')
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ID], [EntryName], [EntryContent], [Image], [Date]) VALUES (1, N'In the Afternoon', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.', N'i282319414620354139._rsw480h360_szw480h360_.jpg', CAST(N'2017-07-19' AS Date))
INSERT [dbo].[Product] ([ID], [EntryName], [EntryContent], [Image], [Date]) VALUES (2, N'Traditional Cakes', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.', N'i282319414620354374._rsw480h360_szw480h360_.jpg', CAST(N'2017-07-19' AS Date))
SET IDENTITY_INSERT [dbo].[Product] OFF
INSERT [dbo].[ShopAbout] ([Address], [Tel], [Email], [OpeningHours], [Signature], [IntroContent], [IntroImage]) VALUES (N'Copenhagen, Denmark', 123456, N'your-email@your-email.com', N'Monday: Closed
Tuesday - Friday: 10:00 - 20:00
Saturday and Sunday: 11.00 - 21:00', N'Maria Bagnarelli', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.

Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica', N'intro.jpg')
USE [master]
GO
ALTER DATABASE [P0015] SET  READ_WRITE 
GO
