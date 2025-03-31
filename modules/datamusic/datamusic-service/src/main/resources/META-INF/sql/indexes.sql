create index IX_88444703 on datamusic_CollectionItem (userAccountId, rating);
create index IX_4E64CBD9 on datamusic_CollectionItem (uuid_[$COLUMN_LENGTH:75$]);

create index IX_26BDFE01 on datamusic_Media (artist[$COLUMN_LENGTH:75$]);
create index IX_492DE1AD on datamusic_Media (genre[$COLUMN_LENGTH:75$]);
create index IX_D07575B9 on datamusic_Media (mediaName[$COLUMN_LENGTH:75$]);
create index IX_48C5BFEE on datamusic_Media (uuid_[$COLUMN_LENGTH:75$]);

create index IX_4248077C on datamusic_UserAccount (userFirstName[$COLUMN_LENGTH:75$]);
create index IX_8F7F09A4 on datamusic_UserAccount (userLastName[$COLUMN_LENGTH:75$]);
create index IX_2C81DDC3 on datamusic_UserAccount (userNameAccount[$COLUMN_LENGTH:75$]);
create index IX_C789B6B0 on datamusic_UserAccount (uuid_[$COLUMN_LENGTH:75$]);