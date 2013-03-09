package org.jboss.errai.enterprise.client.jaxrs;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.URL;
import com.logikas.samples.errai.client.security.SecurityInterseptor;
import com.logikas.samples.errai.client.shared.Customer;
import com.logikas.samples.errai.client.shared.CustomerService;
import java.util.List;
import org.jboss.errai.bus.client.api.ErrorCallback;
import org.jboss.errai.bus.client.api.Message;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.bus.client.framework.CallContextStatus;
import org.jboss.errai.bus.client.framework.ProxyProvider;
import org.jboss.errai.bus.client.framework.RemoteServiceProxyFactory;
import org.jboss.errai.enterprise.client.jaxrs.api.interceptor.RestCallContext;

public class JaxrsProxyLoaderImpl implements JaxrsProxyLoader {
  public void loadProxies() {
    class com_logikas_samples_errai_client_shared_CustomerServiceImpl extends AbstractJaxrsProxy implements CustomerService {
      private RemoteCallback remoteCallback;
      private ErrorCallback errorCallback;
      public RemoteCallback getRemoteCallback() {
        return remoteCallback;
      }

      public void setRemoteCallback(RemoteCallback callback) {
        remoteCallback = callback;
      }

      public ErrorCallback getErrorCallback() {
        return errorCallback;
      }

      public void setErrorCallback(ErrorCallback callback) {
        errorCallback = callback;
      }

      public List listAllCustomers() {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("customers");
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        sendRequest(requestBuilder, null, new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return MarshallingWrapper.fromJSON(response, List.class, Customer.class);
          }
        });
        return null;
      }

      public long createCustomer(final Customer a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("customers");
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, url.toString());
        requestBuilder.setHeader("Accept", "text/plain");
        requestBuilder.setHeader("Content-Type", "application/json");
        try {
          final CallContextStatus status = new CallContextStatus(SecurityInterseptor.class);
          final RestCallContext callContext = new RestCallContext() {
            public String getMethodName() {
              return "createCustomer";
            }
            public Object proceed() {
              status.proceed();
              if (status.getNextInterceptor() != null) {
                if (status.getNextInterceptor() == SecurityInterseptor.class) {
                  status.setProceeding(false);
                  new SecurityInterseptor().aroundInvoke(this);
                  if (!status.isProceeding()) {
                    remoteCallback.callback(getResult());
                  }
                }
              } else {
                com_logikas_samples_errai_client_shared_CustomerServiceImpl.this.sendRequest(getRequestBuilder(), MarshallingWrapper.toJSON(a0), new ResponseDemarshallingCallback() {
                  public Object demarshallResponse(String response) {
                    return Long.valueOf(response);
                  }
                });
              }
              return null;
            }
            public void proceed(final RemoteCallback interceptorCallback) {
              final RemoteCallback providedCallback = com_logikas_samples_errai_client_shared_CustomerServiceImpl.this.remoteCallback;
              remoteCallback = new RemoteCallback() {
                public void callback(Object response) {
                  RemoteCallback intCallback = interceptorCallback;
                  setResult(response);
                  intCallback.callback(getResult());
                  providedCallback.callback(getResult());
                }
              };
              proceed();
            }
            public void proceed(RemoteCallback interceptorCallback, final ErrorCallback interceptorErrorCallback) {
              final ErrorCallback providedErrorCallback = com_logikas_samples_errai_client_shared_CustomerServiceImpl.this.errorCallback;
              errorCallback = new ErrorCallback() {
                public boolean error(Message message, Throwable throwable) {
                  interceptorErrorCallback.error(message, throwable);
                  providedErrorCallback.error(message, throwable);
                  return true;
                }
              };
              proceed(interceptorCallback);
            }
            public void setParameters(Object[] parameters) {
              super.setParameters(parameters);
              StringBuilder url = new StringBuilder(getBaseUrl());
              url.append("customers");
              RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, url.toString());
              requestBuilder.setHeader("Accept", "text/plain");
              requestBuilder.setHeader("Content-Type", "application/json");
              setRequestBuilder(requestBuilder);
            }
          };
          callContext.setRequestBuilder(requestBuilder);
          callContext.setParameters(new Object[] { a0 });
          callContext.proceed();
        } catch (Throwable throwable) {
          com_logikas_samples_errai_client_shared_CustomerServiceImpl.this.handleError(throwable, null);
        }
        return 0L;
      }

      public Customer updateCustomer(final long a0, final Customer a1) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("customers/{id}".replace("{id}", URL.encodePathSegment(new Long(a0).toString())));
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.PUT, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        requestBuilder.setHeader("Content-Type", "application/json");
        sendRequest(requestBuilder, MarshallingWrapper.toJSON(a1), new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return MarshallingWrapper.fromJSON(response, Customer.class, null);
          }
        });
        return null;
      }

      public void deleteCustomer(final long a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("customers/{id}".replace("{id}", URL.encodePathSegment(new Long(a0).toString())));
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.DELETE, url.toString());
        sendRequest(requestBuilder, null, new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return null;
          }
        });
      }

      public Customer retrieveCustomerById(final long a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("customers/{id}".replace("{id}", URL.encodePathSegment(new Long(a0).toString())));
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        sendRequest(requestBuilder, null, new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return MarshallingWrapper.fromJSON(response, Customer.class, null);
          }
        });
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(CustomerService.class, new ProxyProvider() {
      public Object getProxy() {
        return new com_logikas_samples_errai_client_shared_CustomerServiceImpl();
      }
    });
  }
}