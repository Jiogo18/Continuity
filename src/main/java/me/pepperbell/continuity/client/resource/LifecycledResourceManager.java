package me.pepperbell.continuity.client.resource;

import net.minecraft.resource.ResourceManager;

public interface LifecycledResourceManager extends ResourceManager, AutoCloseable {
    void close();
}
