package com.example.compstore.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.PositiveOrZero;

@MappedSuperclass
@DynamicUpdate
public abstract class DisplayIncludedComputer extends Computer {
    @PositiveOrZero
    private int displayDiagonalSize;
    private String displayResolution;
    @PositiveOrZero
    private int refreshRate;
    private boolean touchScreenSupported;
    private boolean hasWebCam;
    private String webCamResolution;

    public int getDisplayDiagonalSize() {
        return displayDiagonalSize;
    }

    public void setDisplayDiagonalSize(int displayDiagonalSize) {
        this.displayDiagonalSize = displayDiagonalSize;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public boolean isTouchScreenSupported() {
        return touchScreenSupported;
    }

    public void setTouchScreenSupported(boolean touchScreenSupported) {
        this.touchScreenSupported = touchScreenSupported;
    }

    public boolean getHasWebCam() {
        return hasWebCam;
    }

    public void setHasWebCam(boolean hasWebCam) {
        this.hasWebCam = hasWebCam;
    }

    public String getWebCamResolution() {
        return webCamResolution;
    }

    public void setWebCamResolution(String webCamResolution) {
        this.webCamResolution = webCamResolution;
    }

    @Override
    public String toString() {
        return super.toString() + '\n'
                + "displayDiagonalSize=" + displayDiagonalSize + '\n'
                + "displayResolution='" + displayResolution + '\'' + '\n'
                + "refreshRate=" + refreshRate + '\n'
                + "touchScreenSupported=" + touchScreenSupported + '\n'
                + "hasWebCam=" + hasWebCam + '\n'
                + "webCamResolution=" + webCamResolution;
    }
}
