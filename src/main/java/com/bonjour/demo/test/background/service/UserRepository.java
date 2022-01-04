package com.bonjour.demo.test.background.service;

import com.bonjour.demo.test.common.dto.ESUserDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @authur tc
 * @date 2021/11/17 20:40
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<ESUserDTO, Integer> {
}
