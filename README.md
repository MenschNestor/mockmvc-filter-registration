# mockmvc-filter-registration

This is a test project meant to highlight a difference in filter registration
between a normal Spring Boot application startup and a test annotated with
`@AutoConfigureMockMvc`.

The setup is roughly the following:

There is an auto configuration `SampleFilterAutoConfiguration` that creates
a `FilterRegistrationBean` registering a `SampleFilter` with order 0. The
assumption is that this would happen inside a library.

There is another (non-auto) configuration `ReorderingFilterConfiguration` that
aims to override the order of the `SampleFilter` to
`Ordered.HIGHEST_PRECEDENCE` by registering another `FilterRegistrationBean`
with the same filter instance.

On application startup, this leads to a single addition of the filter to the
filter chain. The second addition with the lower order is ignored in
`AbstractFilterRegistrationBean` because the servlet context returns null due
to the already existing filter.

On test startup, however, the `SpringBootMockMvcBuilderCustomizer` simply adds
all filters to a list, which leads to a duplicate entry of the same filter to
the mock filter chain. You can see this because the filter logs a message twice
during a single HTTP request, as opposed to sending the same request to the
application started in the normal way.
