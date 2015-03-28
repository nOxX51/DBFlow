package com.raizlabs.android.dbflow.test.sql;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.annotation.UniqueGroup;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.test.TestDatabase;

/**
 * Description:
 */
@Table(databaseName = TestDatabase.NAME,
        uniqueColumnGroups = {@UniqueGroup(groupNumber = 1, uniqueConflict = ConflictAction.ROLLBACK),
                @UniqueGroup(groupNumber = 2, uniqueConflict = ConflictAction.REPLACE)})
public class UniqueModel extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    long id;

    @Column(onUniqueConflict = ConflictAction.REPLACE)
    @Unique(uniqueGroups = 1)
    String uniqueName;

    @Column(onUniqueConflict = ConflictAction.ROLLBACK)
    @Unique(uniqueGroups = 2)
    String anotherUnique;

    @Column
    @Unique(uniqueGroups = {1, 2})
    String sharedUnique;
}
