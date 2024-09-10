package com.tms.tms.model;

import com.tms.tms.dto.HubRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "p_hubs")
public class Hub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hub_id")
    private Long hubId;

    @Column(nullable = false, unique = true)
    private String hubRegion;

    private double hubAddressX;

    private double hubAddressY;

    private boolean isDelete = false;

    @OneToMany(mappedBy = "hub")
    private List<Store> storeList = new ArrayList<>();

    public Hub(HubRequestDto hubRequestDto){
        this.hubRegion = hubRequestDto.getHubRegion();
        this.hubAddressX = hubRequestDto.getHubAddressX();
        this.hubAddressY = hubRequestDto.getHubAddressY();
    }
}
