package com.mini_builder.mini_builder.common.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseTimeEntity implements Serializable {

    //    @CreatedDate
    private LocalDateTime created_at;

    //    @LastModifiedDate
    private LocalDateTime updated_at;
}
