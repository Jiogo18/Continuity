package me.pepperbell.continuity.client.mixin;

import me.pepperbell.continuity.client.resource.LifecycledResourceManager;

public interface ReloadableResourceManagerImplAccessor {
	LifecycledResourceManager getActiveManager();
}
