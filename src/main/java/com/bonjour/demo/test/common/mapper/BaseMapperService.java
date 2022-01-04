package com.bonjour.demo.test.common.mapper;

import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.UpdateChainWrapper;

import java.util.List;

/**
 * @authur tc
 * @date 2021/11/27 14:55
 */
public interface BaseMapperService {

    <E, M extends BaseMapperPro<E>> void insert(E entity, Class<M> mapperClz);

    <E, M extends BaseMapperPro<E>> void insert(List<E> list, Class<M> mapperClz);

    <E, M extends BaseMapperPro<E>> void updateById(E entity, Class<M> mapperClz);

    <E, M extends BaseMapperPro<E>> void updateById(List<E> list, Class<M> mapperClz);

    <E, M extends BaseMapperPro<E>> void updateAllById(E entity, Class<M> mapperClz);

    <E, M extends BaseMapperPro<E>> void updateAllById(List<E> list, Class<M> mapperClz);

    <E, M extends BaseMapperPro<E>> QueryChainWrapper<E> query(Class<M> mapperClz);

    <E, M extends BaseMapperPro<E>> UpdateChainWrapper<E> update(Class<M> mapperClz);

    <E, M extends BaseMapperPro<E>> M getMapper(Class<M> mapperClz);
}
