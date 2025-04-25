package com.example.spring_hibernate_maven.dto;

import com.example.spring_hibernate_maven.entity.Admin;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class AdminDto extends CommonDto<Admin> {;
    private Boolean root;

    @Override
    public Admin convertToEntity() {
        Admin admin = new Admin();
        fillCommonFields(admin);
        admin.setRoot(this.root);
        return admin;
    }

    @Override
    public void convertToDTO(Admin entity) {
        super.convertToDTO(entity);
        root = entity.isRoot();
    }
}
