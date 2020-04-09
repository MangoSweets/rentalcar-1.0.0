package com.person.rentalcar.redis.api;

public interface ISyncCacheService {

	Boolean getLock(String lockName, int expireTime);

	Boolean releaseLock(String lockName);
}
