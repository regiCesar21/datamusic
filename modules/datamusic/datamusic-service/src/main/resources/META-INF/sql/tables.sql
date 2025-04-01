create table datamusic_CollectionItem (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	collectionItemId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	userAccountId LONG,
	mediaId LONG,
	review VARCHAR(75) null,
	rating LONG
);

create table datamusic_Media (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	mediaId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	mediaName VARCHAR(75) null,
	artist VARCHAR(75) null,
	description VARCHAR(75) null,
	genre VARCHAR(75) null
);

create table datamusic_UserAccount (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	userAccountId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	userNameAccount VARCHAR(75) null,
	userFirstName VARCHAR(75) null,
	userLastName VARCHAR(75) null
);