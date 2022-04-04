package com.mirea.homedepot.catalogservice.core.service;
/*

import com.mirea.homedepot.catalogservice.core.repository.BasicMethodRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CrudServiceImpl<D, E, R extends BasicMethodRepository<E>> {

    private final R r;
    private final ModelMapper modelMapper;

    public CrudServiceImpl(R r, ModelMapper modelMapper) {
        this.r = r;
        this.modelMapper = modelMapper;
    }

    public List<D> findAll() {
        List<E> eList = r.findAll();
        return eList.stream().map(el -> modelMapper.map(el, D.class)).collect(Collectors.toList());
    }

    public D findById(Long id) {
        E e = r.findById(id);
        return modelMapper.map(e, E.class);
    }

    public List<D> findByListId(List<Long> listId) {
        List<E> eList = r.findByListId(listId);
        return eList.stream().map(el -> modelMapper.map(el, D.class)).collect(Collectors.toList());
    }

    public void insert(D d) {
        E entity = modelMapper.map(d, E.class);
        if (entity.getId() == null) r.insert(entity);
        else r.update(entity);
    }

    public void insertList(List<D> dtoList) {
        List<E> eList =
                dtoList.stream().map(el -> modelMapper.map(el, E.class)).collect(Collectors.toList());
        r.insertList(eList);
    }

    public void update(D d) {
        E e = modelMapper.map(d, E.class);
        r.update(e);
    }

    public void deleteById(Long id) {
        r.deleteById(id);
    }
}
*/
