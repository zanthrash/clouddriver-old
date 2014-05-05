package com.netflix.kato.deploy

/**
 * A DeployHandler takes a parameterized description object and performs some deployment operation based off of its
 * detail. These objects may most often be derived from a {@link DeployHandlerRegistry} implementation.
 *
 * @param <T> the type of the {@link DeployDescription}
 * @see DeployDescription
 * @author Dan Woods
 */
public interface DeployHandler<T> {
  /**
   * A method that performs the deployment action described by the description object and returns its results as an
   * implementation of {@link DeploymentResult}
   *
   * @param description
   * @param outputs from prior operations
   * @return deployment result object
   */
  DeploymentResult handle(T description, List priorOutputs)

  /**
   * Used to determine if this handler is suitable for processing the supplied description object.
   *
   * @param description
   * @return true/false
   */
  boolean handles(DeployDescription description)
}