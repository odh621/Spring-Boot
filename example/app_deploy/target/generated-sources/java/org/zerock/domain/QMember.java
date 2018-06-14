package org.zerock.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 264152976L;

    public static final QMember member = new QMember("member1");

    public final DateTimePath<java.time.LocalDateTime> regdate = createDateTime("regdate", java.time.LocalDateTime.class);

    public final ListPath<MemberRole, QMemberRole> roles = this.<MemberRole, QMemberRole>createList("roles", MemberRole.class, QMemberRole.class, PathInits.DIRECT2);

    public final StringPath uid = createString("uid");

    public final StringPath uname = createString("uname");

    public final DateTimePath<java.time.LocalDateTime> updatedate = createDateTime("updatedate", java.time.LocalDateTime.class);

    public final StringPath upw = createString("upw");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

