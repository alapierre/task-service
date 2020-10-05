package io.alapierre.task.service.core.service;

import io.alapierre.task.service.core.exceptions.ApplicationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created 04.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
public abstract class CrudService<E, K, R extends JpaRepository<E, K> & JpaSpecificationExecutor<E>> {

    protected R repository;

    protected CrudService(R repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Optional<E> getById(@NotNull K id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<E> getAll() {
        return repository.findAll();
    }

    @Transactional
    public E add(@NotNull E element) {
        return repository.save(element);
    }

    @Transactional
    public E update(@NotNull E element) {
        return repository.save(element);
    }

    @Transactional
    void delete(@NotNull E element) {
        repository.delete(element);
    }

    @Transactional
    void delete(@NotNull Collection<E> elements) {
        if(elements.isEmpty()){
            return;
        }
        repository.deleteInBatch(elements);
    }

    @Transactional
    public List<E> getByIds(@NotNull Collection<K> ids) {
        if(CollectionUtils.isEmpty(ids)){
            return Collections.emptyList();
        }
        return repository.findAllById(ids);
    }

    @Transactional
    public E getByIdOrException(@NotNull K id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApplicationException("exception.immigration.customerDoesNotExist", id));
    }
}
