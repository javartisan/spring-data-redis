/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.keyvalue.redis.connection;

import java.util.List;
import java.util.Set;

/**
 * Interface for the commands supported by Redis.
 * 
 * @author Costin Leau
 */
public interface RedisCommands extends RedisTxCommands, RedisStringCommands, RedisListCommands, RedisSetCommands,
		RedisZSetCommands, RedisHashCommands, RedisServerCommands, RedisPubSubCommands {

	Boolean exists(byte[] key);

	Long del(byte[]... keys);

	DataType type(byte[] key);

	Set<byte[]> keys(byte[] pattern);

	byte[] randomKey();

	void rename(byte[] oldName, byte[] newName);

	Boolean renameNX(byte[] oldName, byte[] newName);

	Boolean expire(byte[] key, long seconds);

	Boolean expireAt(byte[] key, long unixTime);

	Boolean persist(byte[] key);

	Long ttl(byte[] key);

	void select(int dbIndex);

	byte[] echo(byte[] message);

	String ping();

	// sort commands
	List<byte[]> sort(byte[] key, SortParameters params);

	Long sort(byte[] key, SortParameters params, byte[] storeKey);
}